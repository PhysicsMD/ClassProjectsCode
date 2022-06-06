// Lab2 module
module lab2(rst, clk, S, V, ss1, ss0);
input  clk , rst , S;
input [3:0] V ;  
output  reg [6:0] ss1 , ss0 ;  

reg [7:0] acc;
 
always  @ ( posedge clk )  begin  // posedge clk  
 if  ( rst )  begin  // if  
acc = 0 ;
end
else begin
case(S)
1:begin
acc = acc - V;
end
0:begin
acc = acc+V;
end
endcase
end
end
always @( acc ) begin

case  ( acc[3:0] )
    4'b0000  :   ss0  =  7'b1000000 ;
    4'b0001  :   ss0  =  7'b1111001 ;
    4'b0010  :   ss0  =  7'b0100100 ;
    4'b0011  :   ss0  =  7'b0110000 ;
    4'b0100  :   ss0  =  7'b0011001 ;
    4'b0101  :   ss0  =  7'b0010010 ;
    4'b0110  :   ss0  =  7'b0000010 ;
    4'b0111  :   ss0  =  7'b1111000 ;
    4'b1000  :   ss0  =  7'b0000000 ;
    4'b1001  :   ss0  =  7'b0010000 ;
    4'b1010  :   ss0  =  7'b0001000 ;
    4'b1011  :   ss0  =  7'b0000011 ;
    4'b1100  :   ss0  =  7'b1000110 ;
    4'b1101  :   ss0  =  7'b0100001 ;
    4'b1110  :   ss0  =  7'b0000110 ;
    4'b1111  :   ss0  =  7'b0001110 ;
  endcase

  case  ( acc[7:4] )
    4'b0000  :   ss1  =  7'b1000000 ;
    4'b0001  :   ss1  =  7'b1111001 ;
    4'b0010  :   ss1  =  7'b0100100 ;
    4'b0011  :   ss1  =  7'b0110000 ;
    4'b0100  :   ss1  =  7'b0011001 ;
    4'b0101  :   ss1  =  7'b0010010 ;
    4'b0110  :   ss1  =  7'b0000010 ;
    4'b0111  :   ss1  =  7'b1111000 ;
    4'b1000  :   ss1  =  7'b0000000 ;
    4'b1001  :   ss1  =  7'b0010000 ;
    4'b1010  :   ss1  =  7'b0001000 ;
    4'b1011  :   ss1  =  7'b0000011 ;
    4'b1100  :   ss1  =  7'b1000110 ;
    4'b1101  :   ss1  =  7'b0100001 ;
    4'b1110  :   ss1  =  7'b0000110 ;
    4'b1111  :   ss1  =  7'b0001110 ;
  endcase  
end
endmodule