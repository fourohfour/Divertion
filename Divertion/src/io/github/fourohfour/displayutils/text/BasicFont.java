package io.github.fourohfour.displayutils.text;

import io.github.fourohfour.displayutils.text.Font;
import io.github.fourohfour.displayutils.text.GraphicChar;

public class BasicFont extends Font{

	protected void setFont(){
		res = 8;
		space = 1;
		this.DefaultGC = new GraphicChar(new Boolean[][] {{true, true, true, true},
	    									              {true, true, true, true},
										                  {true, true, true, true},
										                  {true, true, true, true},
										                  {true, true, true, true},
									                      {true, true, true, true},
									                      {true, true, true, true},
										                  {true, true, true, true}});
		
		this.font.put('A', new GraphicChar(new Boolean[][] {{false, true, true, false},
				                                            {true, false, false, true},
				                                            {true, false, false, true},
				                                            {true, false, false, true},
				                                            {true, true, true, true},
				                                            {true, false, false, true},
				                                            {true, false, false, true},
				                                            {true, false, false, true}}));
		
		this.font.put('B', new GraphicChar(new Boolean[][] {{true, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, false}}));
		
		this.font.put('C', new GraphicChar(new Boolean[][] {{false, true, true, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {false, true, true, true}}));
		
		this.font.put('D', new GraphicChar(new Boolean[][] {{true, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, false}}));
		
		this.font.put('E', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, true}}));
		
		this.font.put('F', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false}}));
		
		this.font.put('F', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false}}));
		
		this.font.put('G', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {true, false, false, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, true, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, true}}));

		this.font.put('H', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true}}));
		
		this.font.put('I', new GraphicChar(new Boolean[][] {{false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false}}));
		
		this.font.put('J', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {true, true, true, false}}));
		
		this.font.put('K', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, true, false},
                                                            {true, true, false, false},
                                                            {true, true, false, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {true, false, false, true}}));
		
		this.font.put('L', new GraphicChar(new Boolean[][] {{true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, true}}));
		
		this.font.put('M', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, true, true, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true}}));
		
		this.font.put('N', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, false, true},
                                                            {true, true, false, true},
                                                            {true, false, true, true},
                                                            {true, false, true, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true}}));
		
		this.font.put('O', new GraphicChar(new Boolean[][] {{false, true, true, false},
	                                                        {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false}}));
		
		this.font.put('P', new GraphicChar(new Boolean[][] {{true, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false}}));
		
		this.font.put('Q', new GraphicChar(new Boolean[][] {{false, true, false, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {false, true, false, true}}));
		
		this.font.put('R', new GraphicChar(new Boolean[][] {{true, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true}}));
		
		this.font.put('S', new GraphicChar(new Boolean[][] {{false, true, true, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {false, true, true, false},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {true, true, true, false}}));
		
		this.font.put('T', new GraphicChar(new Boolean[][] {{false, true, true, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false}}));
		
		this.font.put('U', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false}}));
		
		this.font.put('V', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false},
                                                            {false, true, true, false}}));
		
		this.font.put('W', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, true},
                                                            {true, false, false, true}}));
		
		this.font.put('X', new GraphicChar(new Boolean[][] {{true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false},
                                                            {false, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true}}));
		
		this.font.put('Y', new GraphicChar(new Boolean[][] {{false, true, false, true},
                                                            {false, true, false, true},
                                                            {false, true, false, true},
                                                            {false, true, false, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false}}));
		
		this.font.put('Z', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {false, false, false, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, true}}));
		
		
		this.font.put('0', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, true, true, true}}));
		
		this.font.put('1', new GraphicChar(new Boolean[][] {{false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false}}));
		
		this.font.put('2', new GraphicChar(new Boolean[][] {{false, true, true, false},
                                                            {true, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, true, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, true}}));
		
		this.font.put('3', new GraphicChar(new Boolean[][] {{true, true, true, false},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, true, true, true},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {true, true, true, false}}));
		
		this.font.put('4', new GraphicChar(new Boolean[][] {{true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, false, true, false},
                                                            {true, false, true, false},
                                                            {true, true, true, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false}}));
		
		this.font.put('5', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, false},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {true, true, true, false}}));
		
		this.font.put('6', new GraphicChar(new Boolean[][] {{false, true, true, true},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {true, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false}}));
		
		this.font.put('7', new GraphicChar(new Boolean[][] {{true, true, true, true},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false}}));
		
		this.font.put('8', new GraphicChar(new Boolean[][] {{false, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false}}));
		
		this.font.put('9', new GraphicChar(new Boolean[][] {{false, true, true, false},
                                                            {true, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, true},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {true, false, false, true},
                                                            {false, true, true, false}}));
		
		this.font.put(' ', new GraphicChar(new Boolean[][] {{false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false}}));
		
		this.font.put('.', new GraphicChar(new Boolean[][] {{false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, true, true, false},
                                                            {false, true, true, false}}));
		
		this.font.put('>', new GraphicChar(new Boolean[][] {{true, false, false, false},
                                                            {false, true, false, false},
                                                            {false, false, true, false},
                                                            {false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, true, false},
                                                            {false, true, false, false},
                                                            {true, false, false, false}}));
		
		this.font.put('<', new GraphicChar(new Boolean[][] {{false, false, false, true},
                                                            {false, false, true, false},
                                                            {false, true, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false},
                                                            {false, true, false, false},
                                                            {false, false, true, false},
                                                            {false, false, false, true}}));
		
		this.font.put(':', new GraphicChar(new Boolean[][] {{false, false, false, false},
                                                            {false, true, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, true, false, false},
                                                            {false, false, false, false}}));
		
		this.font.put(';', new GraphicChar(new Boolean[][] {{false, false, false, false},
                                                            {false, true, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, true, false, false},
                                                            {true, false, false, false}}));
		
		this.font.put('\\', new GraphicChar(new Boolean[][] {{true, false, false, false},
                                                            {true, false, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, false, true},
                                                            {false, false, false, true}}));
		
		
		this.font.put('/', new GraphicChar(new Boolean[][] {{false, false, false, true},
                                                            {false, false, false, true},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {true, false, false, false},
                                                            {true, false, false, false}}));
		
		this.font.put('?', new GraphicChar(new Boolean[][] {{false, true, false, false},
                                                            {true, false, true, false},
                                                            {false, false, true, false},
                                                            {false, false, true, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, false, false, false},
                                                            {false, true, false, false}}));
		
		this.font.put('!', new GraphicChar(new Boolean[][] {{false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, false, false, false},
                                                            {false, true, false, false}}));
		
		this.font.put('+', new GraphicChar(new Boolean[][] {{false, false, false, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {true, true, true, false},
                                                            {false, true, false, false},
                                                            {false, true, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false}}));
		
		this.font.put('-', new GraphicChar(new Boolean[][] {{false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {true, true, true, true},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false},
                                                            {false, false, false, false}}));
	}
}
