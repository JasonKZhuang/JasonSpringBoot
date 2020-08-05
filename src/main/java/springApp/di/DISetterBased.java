package springApp.di;

public class DISetterBased
{
	// This class has a dependency on a MovieFinder
	private MovieFinder1 movieFinder1;

	private MovieFinder2 movieFinder2;

	private int idx = 0;

	private DISetterBased()
	{
	}

	// business logic that actually uses the injected MovieFinder is omitted...
	public void execute()
	{
		System.out.println("==Setter-based injection=====================");
		System.out.println("==>The idx of this class is " + this.idx);
		this.movieFinder1.method1();
		this.movieFinder2.method1();
		System.out.println("==============================================");
	}

	/* get set methods */
	public MovieFinder1 getMovieFinder1()
	{
		return movieFinder1;
	}

	public void setMovieFinder1(MovieFinder1 movieFinder1)
	{
		this.movieFinder1 = movieFinder1;
	}

	public MovieFinder2 getMovieFinder2()
	{
		return movieFinder2;
	}

	public void setMovieFinder2(MovieFinder2 movieFinder2)
	{
		this.movieFinder2 = movieFinder2;
	}

	public int getIdx()
	{
		return idx;
	}

	public void setIdx(int idx)
	{
		this.idx = idx;
	}

}
