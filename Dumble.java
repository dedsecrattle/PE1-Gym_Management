class Dumble extends Equipment{
  private final double weight;
  private boolean inUse;

  public Dumble(double weight){
    this.weight = weight;
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
    String str = "Dumble with weight " + this.weight;
    return super.toString() + str;
  }
}
