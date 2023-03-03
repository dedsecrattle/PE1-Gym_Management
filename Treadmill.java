class Treadmill extends Equipment{
  private final double speed;
  private boolean inUse;

  public Treadmill(double speed){
    this.speed = speed;
  }

  public boolean inUse(){
    return this.inUse;
  }

  public void setInUse(){
    this.inUse = true;
  }

  public void setAvailable(){
    this.inUse = false;
  }

  @Override
  public String toString(){
    String str = "Treadmill at speed " + this.speed;
    return super.toString() + str;
  }
}
