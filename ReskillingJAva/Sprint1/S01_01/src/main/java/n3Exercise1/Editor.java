package n3Exercise1;
import n3Exercise1.news.NewsReport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Editor {
    private String name;
    private final String dni;
    private static int salary = 1500;
    private ArrayList<NewsReport> newsReports;

    Editor(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.newsReports = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public static int getSalary() {
        return salary;
    }

    public ArrayList<NewsReport> getNoticias() {
        return newsReports;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setSalary(int salary) {
        Editor.salary = salary;
    }

    public void setNews(ArrayList<NewsReport> newsReports) {
        this.newsReports = newsReports;
    }

    @Override
    public String toString() {
        return "Editor [name=" + name + ", DNI=" + dni + ", news=" + newsReports + " salary=" + salary + "]";
    }

    public void inputNew(NewsReport newsReport) {
        newsReports.add(newsReport);
    }

    public NewsReport seekNew(String titular) {
        NewsReport newsReport = null;
        Optional<NewsReport> expression = newsReports.stream().filter(o -> o.getTitular().equalsIgnoreCase(titular)).findFirst();

        if (expression.isPresent()) {
            newsReport = expression.get();
        }
        return newsReport;
    }

    public boolean removeNew(NewsReport newsReport) {
        return newsReports.remove(newsReport);
    }

    public String showNews() {
        String result = "";
       
        newsReports.sort(Comparator.comparing(NewsReport::getTitular));

        if (!newsReports.isEmpty()) {
            for (NewsReport newsReport : newsReports) {
                result+=newsReport.toString()+"\n";
            }
        } else {
            result = "Editor have no news.";
        }
        return result;
    }
    
    public String showTitulars() {
        String result = "";
        newsReports.sort(Comparator.comparing(NewsReport::getTitular));
        
        if (!newsReports.isEmpty()) {
            System.out.println("List of news:");
            for (NewsReport newsReport : newsReports) {
                result+="Sport: "+newsReport.getSport()+" | Titular: "+newsReport.getTitular()+"\n";
            }
        } else {
            result ="Editor have no news.";
        }
        return result;
    }
}

