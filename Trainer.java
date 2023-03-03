class Trainer extends People{
  private final String name;
  private boolean isTraining;
  private Customer customer;
  private Equipment equipment;
  
  public Trainer(String name){
    this.name = name;
  }

  public void finishTrain(){
    this.isTraining = false;
    this.customer.finishTraining();
    this.equipment.setAvailable();
    this.customer = null;
    this.equipment = null;
  }

  public void startTraining(){
    this.isTraining = true;
  }
  public void finishTraining(){
    this.isTraining = false;
  }

  public void startTrain(Equipment equipment, Customer customer){
    this.isTraining = true;
    this.equipment = equipment;
    this.customer = customer;
    this.equipment.setInUse();
    this.customer.startTraining();
  }

  public boolean isTraining(){
    return this.isTraining;
  }

  public String getName(){
    return this.name;
  }

  public String toString(){
    return "Trainer: " + this.name;
  }
}
