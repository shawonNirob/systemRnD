package javaThread;

class FrontDoorBankAccount {
    int balance = 10;

    // Front door lock: same as synchronized(this)
    public synchronized void increment() {
        balance++;
        System.out.println("Incrementer: Added 1. Balance is " + balance);
    }

    // Front door lock: same as synchronized(this)
    public synchronized void decrement() {
        balance--;
        System.out.println("Decrementer: Subtracted 1. Balance is " + balance);
    }
}

class MainBank {
    public static void main(String[] args) throws InterruptedException {
        FrontDoorBankAccount myAccount = new FrontDoorBankAccount();

        // THREAD 1: The Outsider
        Thread outsider = new Thread(() -> {
            // The outsider locks the whole object from the outside!
            synchronized (myAccount) {
                System.out.println("OUTSIDER: I locked the whole account! Sleeping for 5 seconds...");
                try { Thread.sleep(5000); } catch (Exception e) {}
                System.out.println("OUTSIDER: I am finally letting go of the lock.");
            }
        });

        // THREAD 2: The Incrementer (Normal User)
        Thread incrementer = new Thread(() -> {
            System.out.println("Incrementer: Trying to add money...");
            myAccount.increment(); // Gets stuck here!
            System.out.println("Incrementer: Done!");
        });

        // THREAD 3: The Decrementer (Normal User)
        Thread decrementer = new Thread(() -> {
            System.out.println("Decrementer: Trying to subtract money...");
            myAccount.decrement(); // Gets stuck here too!
            System.out.println("Decrementer: Done!");
        });

        // 1. Start the outsider first
        outsider.start();

        // 2. Wait 100 milliseconds to guarantee the outsider grabs the lock first
        Thread.sleep(100);

        // 3. Start the normal users
        incrementer.start();
        decrementer.start();
    }
}
