## Random Generator
Given a list of symbols, each symbol has its own weight:<br>
A: 40<br>
B: 30<br>
C: 20<br>
D: 10<br>
Create a random symbol generator, the returned symbol’s probability should be according to the weight distribution of the given symbols.<br>
getRandom() -> <br>40 / 100 return A<br>
       		   30 / 100 return B <br>
		       20 / 100 return C <br>
		       10 / 100 return D <br>

**0. requirement, clarification, assumtion**<br>
**1. DEFINE public interface - input, output/return, corner case(exceptioin...)**<br>
**2. define required member fields**<br>
**3. implement the public method - concrete logic/algorithm/data structure**<br>
**4. constructor -> handle corner case**<br>


    class SymbolAndWeight {
	    String symbol;
	    int weight;
    }


String[] symbols             int[] weights<br>
[“A”, “B”, “C”, “D”]         [40, 30, 20, 10]

random nextInt(x) -> uniform distribution return [0,x)
40 + 30 + 20 + 10

[0, 40) [40, 70) [70, 90) [90, 100)<br>
   A          B           C           D

[0, 40, 70, 90]  ->  find largest smaller or equals   (this do not know the largest value)<br>
**[40, 70, 90, 100]  ->  find smallest larger than**