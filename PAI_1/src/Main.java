import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Deadlock deadlock;
        Livelock livelock;
        Starvation starvation;

        System.out.printf("Launch DEADLOCK_DEMO - enter '1'\nLaunch LIVELOCK_DEMO - enter '2'\nLaunch STARVATION_DEMO - enter '3'\n");
        Scanner scanner = new Scanner(System.in);
        int i;
        do {
            System.out.printf(">>");
            i = scanner.nextInt();
            switch (i) {

                case 1:
                    deadlock = new Deadlock();
                    deadlock.launch();
                    break;

                case 2:
                    livelock = new Livelock();
                    livelock.launch();
                    break;

                case 3:
                    starvation = new Starvation();
                    starvation.launch();
                    break;

                default:
                    break;

            }

        }
        while(i!=0);
    }
}
