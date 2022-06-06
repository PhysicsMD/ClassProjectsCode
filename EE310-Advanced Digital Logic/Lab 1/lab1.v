//lab1 module
module  lab1  ( clk , rst , ss3 , ss2 , ss1 , ss0 ) ;
input  clk , rst ;    
output reg  [6:0]  ss3 , ss2 , ss1 , ss0 ;

localparam  [2:0]  state____  =  0 ,
                   state1___  =  1 ,
                   state_2__  =  2 ,
                   state__3_  =  3 ,
                   state___4  =  4 ,
						 state1234  =  5 ;

reg  [2:0]  state ;


always  @ ( posedge clk )  begin  // posedge clk
  if  ( rst )  begin  // if
    // Initial state
    state  = state____ ;
  end  // if
  else  begin  // else
    // State transitions
    case  ( state )
	   state____  :  begin
        state  =  state1___ ;
      end
	   state1___  :  begin
        state  =  state_2__ ;
      end
	   state_2__  :  begin
        state  =  state__3_ ;
      end
	   state__3_  :  begin
        state  =  state___4 ;
      end
	   state___4  :  begin
        state  =  state1234 ;
      end
		state1234  :  begin
        state  =  state____ ;
      end
      default  :  begin
        state  =  state____ ;
      end
	 endcase
  end  // else

  // State actions
  case  ( state )
    state____  :  begin
      ss3  =  7'b1111111 ;
      ss2  =  7'b1111111 ;
      ss1  =  7'b1111111 ;
      ss0  =  7'b1111111 ;
    end
    state1___  :  begin
      ss3  =  7'b0100100 ;
      ss2  =  7'b1111111 ;
      ss1  =  7'b1111111 ;
      ss0  =  7'b1111111 ;
    end
    state_2__  :  begin
      ss3  =  7'b1111111 ;
      ss2  =  7'b0011000 ;
      ss1  =  7'b1111111 ;
      ss0  =  7'b1111111 ;
    end
    state__3_  :  begin
      ss3  =  7'b1111111 ;
      ss2  =  7'b1111111 ;
      ss1  =  7'b0010010 ;
      ss0  =  7'b1111111 ;
    end
    state___4  :  begin
      ss3  =  7'b1111111 ;
      ss2  =  7'b1111111 ;
      ss1  =  7'b1111111 ;
      ss0  =  7'b1000000 ;
    end
	 state1234  :  begin
      ss3  =  7'b0100100 ;
      ss2  =  7'b0011000 ;
      ss1  =  7'b0010010 ;
      ss0  =  7'b1000000 ;
    end
    default  :  begin
      ss3  =  7'b1111111 ;
      ss2  =  7'b1111111 ;
      ss1  =  7'b1111111 ;
      ss0  =  7'b1111111 ;
    end
  endcase

end  // posedge clk


endmodule

