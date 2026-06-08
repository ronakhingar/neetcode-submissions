class TimeMap {

    HashMap<String,List<Timestamp>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
      map.computeIfAbsent(key, x->new ArrayList<>()).add(new Timestamp(value,timestamp));

    }
    
    public String get(String key, int timestamp) {
        
        List<Timestamp> list = map.get(key);

        if(list==null){
          return "";
        }

      Timestamp t=new Timestamp("0",timestamp);
        int index = Collections.binarySearch(list,t,(Timestamp a, Timestamp b )->{
          return Integer.compare(a.timestamp,b.timestamp);
        } );

        if(index>=0){
          return list.get(index).value;
        }else{
          index=-(index+1);

          return index>0?list.get(index-1).value:"";

                  }

    }
}

class Timestamp{

String value;
Integer timestamp;

public Timestamp(String val, int timestamp){
this.value=val;
this.timestamp=timestamp;
}


}
