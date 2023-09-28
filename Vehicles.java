public class Vehicles {
  private VehicleNode head;
  private VehicleNode current;

  public Vehicles() {
    head = null;
    current = null;
  }

  public void add(Vehicle veh) {
    if(head == null) {
      head = new VehicleNode(veh, null);
    } else {
      getLastNode().setNext(new VehicleNode(veh, null));
    }
   }

  // append to end of linked list
  public Vehicle getVehicle(String vin) throws VINNotFoundException {
    if(head == null) {
      return null;
    } else {
      VehicleNode tempVeh = head.getNext();
      while(tempVeh != null) {
        Vehicle currentVeh = tempVeh.getValue();
        if(currentVeh.getVIN() == vin) {
          return currentVeh;
        }
        tempVeh = tempVeh.getNext();
      }
    }
    return null;
  }


  // iterator method (only ones that use var current)
  public void reset() {
    current = head;
  }

  public boolean hasNext() {
    return current != null;
  }

  public Vehicle getNext() {
    Vehicle currentVeh = current.getValue();
    current = current.getNext();
    return currentVeh;
  }

  private boolean lastNode(VehicleNode node) {
    return node.getNext() == null;
  }

  private VehicleNode getLastNode() {
    VehicleNode temp = head;
    while(!lastNode(temp)) {
      temp = temp.getNext();
    }
    return temp;
  }
}