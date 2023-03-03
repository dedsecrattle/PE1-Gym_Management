import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class GymManagement {
  public static Equipment[] equipments;
  public static People[] people;
  public static int capacity;
  public static int currentCapacity;
  
  private static final int TREADMILL = 0;
  private static final int DUMBBELL = 1;
  private static final int TRAINER = 0;
  private static final int CUSTOMER = 1;
  private static final int ENTER = 0;
  private static final int START = 1;
  private static final int FINISH = 2;
  
  
  public void printEquipment() {
    for (int i = 0; i < equipments.length; i++) {
      System.out.println(equipments[i].toString());
    }
  }


  public void printPeople() {
    for (int i = 0; i < people.length; i++) {
      System.out.println(people[i].toString());
    }
  }


  public GymManagement() {
    Scanner scanner = new Scanner(System.in);
    
    // Read Equipment
    int numEquipment = scanner.nextInt();
    equipments = new Equipment[numEquipment];
    
    for (int i = 0; i < numEquipment; i++) {
      int equipmentType = scanner.nextInt();
      if (equipmentType == GymManagement.TREADMILL) {
        double speed  = scanner.nextDouble();
        equipments[i] = new Treadmill(speed);
      } else if (equipmentType == GymManagement.DUMBBELL) {
        double weight = scanner.nextDouble();
        equipments[i] = new Dumble(weight);
      }
    }
    
    // Read Customers
    int numPeople = scanner.nextInt();
    people = new People[numPeople];
    
    for (int i = 0; i < numPeople; i++) {
      int peopleKind = scanner.nextInt();
      if (peopleKind == GymManagement.TRAINER) {
        String name = scanner.next();
        people[i] = new Trainer(name);
      } else if (peopleKind == GymManagement.CUSTOMER) {
        String name = scanner.next();
        people[i] = new Customer(name);
      }
    }
    
    // Read Gym Capacity
    capacity = scanner.nextInt();
    currentCapacity = 0;
    
    // Read Actions
    int numActions = scanner.nextInt();
    for (int i = 0; i < numActions; i++) {
      int action = scanner.nextInt();
      if (action == GymManagement.ENTER) {
        int customer = scanner.nextInt();
        if (currentCapacity == capacity) {
          System.out.println("Customer: " + people[customer].getName() + " cannot enter");
        } else {
          currentCapacity = currentCapacity + 1;
          System.out.println("Customer: " + people[customer].getName() + " can enter");
        }
        System.out.println("Gym Capacity: " + currentCapacity + "/" + capacity);
      } else if (action == GymManagement.START) {
        int trainer = scanner.nextInt();
        int customer = scanner.nextInt();
        int equipment = scanner.nextInt();
        if (people[trainer].isTraining() || equipments[equipment].inUse()) {
          System.out.println("Cannot Train!");
        } else {
          people[trainer].startTrain(equipments[equipment],(Customer) people[customer]);
          String equipmentStatus = "";
          equipmentStatus = equipments[equipment].toString();
          System.out.println("Trainer: " + people[trainer].getName() + " training Customer: " 
                                         + people[customer].getName() + " using " + equipmentStatus);
        }
      } else if (action == GymManagement.FINISH) {
        int trainer = scanner.nextInt();
        if (!people[trainer].isTraining()) {
          System.out.println("Trainer: " + people[trainer].getName() + " is not training");
        } else {
          System.out.println("Trainer: " + people[trainer].getName() + " has finished training");
          people[trainer].finishTrain();
        }
      }
    }
  }
}
