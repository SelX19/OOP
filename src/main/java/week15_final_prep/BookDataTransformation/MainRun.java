package week15_final_prep.BookDataTransformation;

public class MainRun {
    public static void main(String[]args){
        FinalPrep prep = new FinalPrep("/Users/selmadjozic/IdeaProjects/OOP_labss/src/main/resources/examprep.csv");
        ReportWriter.writeReport("tmp.csv", prep.getMyBooks());
    }
}
