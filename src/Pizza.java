class Pizza
{
    String name;                    // stores name of the pizza
    int cost_L, cost_M, cost_S;     // variables to store the costs of large, medium and small size pizza
    int time_reqd;                  // stores the time required to make the pizza

    public Pizza(String n, int cl, int cm, int cs, int t)      // parameterized constructor
    {
        name=n;
        cost_L=cl;
        cost_S= cs;
        cost_M= cm;
        time_reqd=t;
    }
}