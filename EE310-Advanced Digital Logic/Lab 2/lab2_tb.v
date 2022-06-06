module lab2_tb;

reg clk_tb, rst_tb, S_tb;
reg [7:0] V_tb, acc_tb;
reg [7:4] msb_tb;
reg [3:0] lsb_tb;
wire [6:0] ss1_tb, ss0_tb;

integer i;


lab2 dut(rst_tb, clk_tb, S_tb, V_tb, ss1_tb, ss0_tb);


// Generate clock
always begin
clk_tb = 0;
#10 ;
clk_tb = 1;
#10 ;
end

 
// Other stimulus
initial begin
rst_tb  =  1 ;
#20 ;
rst_tb  =  0 ;
#20 ;
for(i=0; i<= 10; i = i + 1)begin
S_tb = 0;
V_tb = 4'b1110;
acc_tb = 4'b0000;
#20;
$stop;
end
end
endmodule 