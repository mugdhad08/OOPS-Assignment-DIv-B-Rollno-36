import java.io.*;
import java.util.*;




class GradeMain {
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        int i,count=0;
        String s="", id="";
        Double o=0.0, t=0.0, p=0.0;
        Double minimum=100.0,maximum=0.0,average=0.0,answer=0.0;
        student s1[] = new student[10];
        System.out.println("\n\nWelcome to the Grade Management System\n\n");
        while(true){
        System.out.println("\n\nPlease select anyone of the following \n 1.Enter student's record\n2.Display all students grade\n3.Display Statistics\n4.exit\nenter your choice :");
        int c = sc.nextInt();
        if(c==4)
            break;
        switch(c){
            case 1: s1[count]= new student();
                    System.out.println("enter the name of student:");
                     s=sc.next();
                    System.out.println("enter student id");
                    id=sc.next();
                    System.out.println("Enter marks in assignment one : ");
                    o=sc.nextDouble();
                    System.out.println("enter the marks in assignment two : ");
                    t=sc.nextDouble();
                    System.out.println("enter project marks : ");
                    p=sc.nextDouble();

                    s1[count].setstudentName(s);
                    s1[count].setstudentId(id);
                    s1[count].setassignmentOneMarks(o);
                    s1[count].setassignmentTwoMarks(t);
                    s1[count].setprojectMarks(p);

                    count++;
                    

                    break;
            case 2:System.out.println("\nName\tID\tAss1\tass2\tProj\tTotal\tGrade\n");
                    for( i=0;i<count;i++)
                    {
                        System.out.print((s=s1[i].getstudentName())+"\t");
                        System.out.print((id=s1[i].getstudentId())+"\t");
                        System.out.print((o=s1[i].getassignmentOneMarks())+"\t");
                        System.out.print((t=s1[i].getassignmentTwoMarks())+"\t");
                        System.out.print((p=s1[i].getprojectMarks())+"\t");
                        System.out.print((s1[i].calculateTotalMarks())+"\t");
                        System.out.print((s1[i].getGrade())+"\t");
                        System.out.println();
                    }   

                    break;
             case 3:System.out.println("\nStatistics details\n\n ");
                    for(i=0;i<count;i++)
                    {
                        if((answer=s1[i].calculateTotalMarks()) < minimum){
                            minimum=answer;
                             id=s1[i].getstudentName();
                        }
                    
                    }
                    for( i=0;i<count;i++)
                    {
                        if((answer=s1[i].calculateTotalMarks())>maximum)
                        {
                            maximum=answer;
                            s=s1[i].getstudentName();
                        }
                    }
                    for(i=0;i<count;i++)
                    {
                        average+=s1[i].calculateTotalMarks()/ count;
                    }
                    System.out.println("Minimum marks scored by"+id+" is "+minimum);
                    System.out.println("Maximum marks scored by"+s+" is "+maximum);
                    System.out.println("Average marks scored by class is "+average);
                    average=0.0;
                    break;
             case 4:System.exit(0);
                    
            }
         }
    }
}
 class student{
    String studentName;
    String studentId;
    Double assignmentOneMarks;
    Double assignmentTwoMarks;
    Double projectMarks;
    Double individualTotalMarks;
    String grade;
    public student(){}
    //constructor 
   public student(String s,String id,Double o,Double t,Double p){
        studentName=s;
        studentId=id;
        assignmentOneMarks=o;
        assignmentTwoMarks=t;
        projectMarks=p;
    } 
    // set values
    public void setstudentName(String s){
        this.studentName=s;
    }
    
    public void setstudentId(String id){
        this.studentId=id;
    }

    public void setassignmentOneMarks(Double o){
        this.assignmentOneMarks=o;
    }

    public void setassignmentTwoMarks(Double t){
        this.assignmentTwoMarks=t;
    }

    public void setprojectMarks(Double p){
        this.projectMarks=p;
    }

    //get values
    public String getstudentName(){
        return this.studentName;
    }
    
    public String getstudentId(){
        return this.studentId;
    }

    public Double getassignmentOneMarks(){
        return this.assignmentOneMarks;
    }

    public Double getassignmentTwoMarks(){
      return  this.assignmentTwoMarks;
    }

    public Double getprojectMarks(){
        return this.projectMarks;
    }

    // calculate total marks 
    public Double calculateTotalMarks(){
        individualTotalMarks=this.assignmentOneMarks+this.assignmentTwoMarks+this.projectMarks;
        return individualTotalMarks;
    
    }
    
    // check grade 
    
    public String getGrade(){
        if(individualTotalMarks < 50)
            grade="F";
        else if(individualTotalMarks >=50 && individualTotalMarks <65)
            grade = "P";
        else if(individualTotalMarks >=65 && individualTotalMarks <75)
            grade = "C";
        else if(individualTotalMarks >=75 && individualTotalMarks <85)
            grade = "D";
        else if(individualTotalMarks >=85)
            grade="HD";
        
        return grade;
    }


    }