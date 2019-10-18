package springApp.di;

public class DIConstructorBased
{
	// This class has a dependency on a MovieFinder
    private MovieFinder1 movieFinder1;
    private MovieFinder2 movieFinder2;
    private int idx = 0;
    
    // a constructor so that the Spring container can inject two MovieFinder classes
    public DIConstructorBased(MovieFinder1 movieFinder1, MovieFinder2 movieFinder2, int idx) 
    {
        this.movieFinder1 = movieFinder1;
        this.movieFinder2 = movieFinder2;
        this.idx = idx;
    }

    // business logic that actually uses the injected MovieFinder is omitted...
	public void execute()
	{
		System.out.println("==>The idx of this class is " + this.idx);
		this.movieFinder1.method1();
		this.movieFinder2.method1();
	}
}
