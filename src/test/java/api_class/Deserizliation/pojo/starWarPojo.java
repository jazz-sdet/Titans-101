package api_class.Deserizliation.pojo;

import java.util.List;
import java.util.Map;

public class starWarPojo {
    //"count": 36,
    //    "next": "http://swapi.dev/api/starships/?page=3",
    //    "previous": "http://swapi.dev/api/starships/?page=1",
    //    "results": [
    //        {


    int count;
    String next;
    String previous;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Map<String, Object>> getResults() {
        return results;
    }

    public void setResults(List<Map<String, Object>> results) {
        this.results = results;
    }

    List<Map<String, Object>> results;

}
