abstract class Equipment{
  @Override
  public String toString(){
    return "Equipment: ";
  }
  public abstract boolean inUse();
  public abstract void setInUse();
  public abstract void setAvailable();
}
