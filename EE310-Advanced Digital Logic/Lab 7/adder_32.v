`timescale 1ns / 1ps
module adder_32(A, B, S, Sub);
   input [31:0] A, B;
	input Sub;
   output reg [31:0] S;

	always @(A, B, Sub) begin
	if(Sub == 1)
			S = A - B;
	else
			S = A + B; 
	end
endmodule
