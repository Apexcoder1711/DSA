import java.util.*;

class priorityQueueForObjects { 
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("ayush", 19));
        pq.add(new Student("sagar", 109));
        pq.add(new Student("ankita", 9));
        pq.add(new Student("aniket", 23));

        // ankita 9
        // ayush 19
        // aniket 23
        // sagar 109


        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " " + pq.peek().rank);
            pq.remove();
        }
    }
}