package javaThread;

class SecretVaultBankAccount {
    int balance = 10;

    // THE SECRET VAULT: A private lock only this class knows about
    private final Object vaultLock = new Object();

    public void increment() {
        // Lock the secret vault, NOT the front door
        synchronized(vaultLock) {
            balance++;
            System.out.println("Incrementer: Added 1. Balance is " + balance);
        }
    }

    public void decrement() {
        // Lock the same secret vault so increment and decrement don't conflict
        synchronized(vaultLock) {
            balance--;
            System.out.println("Decrementer: Subtracted 1. Balance is " + balance);
        }
    }
}

class Mainbank {
    public static void main(String[] args) throws InterruptedException {
        SecretVaultBankAccount myAccount = new SecretVaultBankAccount();

        // THREAD 1: The Outsider
        Thread outsider = new Thread(() -> {
            // The outsider tries to lock the front door (myAccount)
            synchronized (myAccount) {
                System.out.println("OUTSIDER: I locked the front door! Sleeping for 5 seconds...");
                try { Thread.sleep(5000); } catch (Exception e) {}
                System.out.println("OUTSIDER: I am finally letting go of the front door.");
            }
        });

        // THREAD 2: The Incrementer (Normal User)
        Thread incrementer = new Thread(() -> {
            System.out.println("Incrementer: Trying to add money...");
            myAccount.increment(); // Succeeds immediately!
            System.out.println("Incrementer: Done!");
        });

        // THREAD 3: The Decrementer (Normal User)
        Thread decrementer = new Thread(() -> {
            System.out.println("Decrementer: Trying to subtract money...");
            myAccount.decrement(); // Succeeds immediately!
            System.out.println("Decrementer: Done!");
        });

        // 1. Start the outsider first
        outsider.start();

        // 2. Wait 100 milliseconds to guarantee the outsider grabs the front door lock
        Thread.sleep(100);

        // 3. Start the normal users
        incrementer.start();
        decrementer.start();
    }
}
