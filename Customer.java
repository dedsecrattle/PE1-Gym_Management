class Customer extends People{
  private final String name;
  private boolean isTraining;
  
  public Customer(String name){
    this.name = name;
  }

  public boolean isTraining(){
    return this.isTraining;
  }

  public void startTraining(){
    this.isTraining = true;
  }

  public void finishTraining(){
    this.isTraining = false;
  }
  public String getName(){
    return this.name;
  }

  public String toString(){
    return "Customer: " + this.name;
  }

  public void startTrain(Equipment equipment, Customer customer){
  }

  public void finishTrain(){
  }
}
