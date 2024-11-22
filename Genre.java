// Base class Genre
class Genre {
    protected String title;
    protected String author;
    protected int yearPublished;

    // Constructor
    public Genre(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
    }
}

// Subclass Fiction
class Fiction extends Genre {
    private String subgenre;

    // Constructor for Fiction
    public Fiction(String title, String author, int yearPublished, String subgenre) {
        super(title, author, yearPublished);
        this.subgenre = subgenre;
    }

    // Overriding the displayDetails method with color
    @Override
    public void displayDetails() {
        System.out.println("\033[0;34m" + "Fiction Book:"); // Blue text
        super.displayDetails();
        System.out.println("Subgenre: " + subgenre);
        System.out.println("\033[0m"); // Reset color
    }
}

// Subclass NonFiction
class NonFiction extends Genre {
    private String subject;

    // Constructor for NonFiction
    public NonFiction(String title, String author, int yearPublished, String subject) {
        super(title, author, yearPublished);
        this.subject = subject;
    }

    // Overriding the displayDetails method with color
    @Override
    public void displayDetails() {
        System.out.println("\033[0;32m" + "Non-Fiction Book:"); // Green text
        super.displayDetails();
        System.out.println("Subject: " + subject);
        System.out.println("\033[0m"); // Reset color
    }
}

// Subclass ScienceFiction
class ScienceFiction extends Genre {
    private String futuristicConcept;

    // Constructor for ScienceFiction
    public ScienceFiction(String title, String author, int yearPublished, String futuristicConcept) {
        super(title, author, yearPublished);
        this.futuristicConcept = futuristicConcept;
    }

    // Overriding the displayDetails method with color
    @Override
    public void displayDetails() {
        System.out.println("\033[0;35m" + "Science Fiction Book:"); // Purple text
        super.displayDetails();
        System.out.println("Futuristic Concept: " + futuristicConcept);
        System.out.println("\033[0m"); // Reset color
    }
}

