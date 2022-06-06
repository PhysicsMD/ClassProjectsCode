`timescale 1ns / 1ps
module mipszy_ctrl(ir31_26, ir5_0,
                   rf_wd_s, rf_wa_s, rf_we, rf_r1e, rf_r2e,
                   add2_s,
                   dm_we, dm_re, add_sub);    

   input [5:0] ir31_26, ir5_0;
   output reg rf_wd_s, rf_wa_s, rf_we, rf_r1e, rf_r2e;
   output reg add2_s;
   output reg dm_we, dm_re;
	output reg add_sub;

   always @* begin
      if (ir31_26 == 'b100011) begin // lw
         rf_wd_s = 0;
         rf_wa_s = 1;
         rf_we = 1;
         rf_r1e = 1;
         rf_r2e = 0;
         add2_s = 0;
         dm_we = 0;
         dm_re = 1;  
			add_sub = 0;
      end
      else if (ir31_26 == 'b101011) begin // sw
         rf_wd_s = 0;
         rf_wa_s = 0;
         rf_we = 0; 
         rf_r1e = 1;
         rf_r2e = 1;
         add2_s = 0;
         dm_we = 1;
         dm_re = 0;  
			add_sub = 0;
      end
      else if (ir31_26 == 'b001000) begin // addi
         rf_wd_s = 1;
         rf_wa_s = 1;
         rf_we = 1;
         rf_r1e = 1;
         rf_r2e = 0;
         add2_s = 0;
         dm_we = 0;
         dm_re = 0;
			add_sub = 0;
      end
      else if (ir31_26 == 'b000000 &&
               ir5_0   == 'b100000) begin // add
         rf_wd_s = 1;
         rf_wa_s = 0;
         rf_we = 1;
         rf_r1e = 1;
         rf_r2e = 1;
         add2_s = 1;
         dm_we = 0;
         dm_re = 0;
			add_sub = 0;
      end
		else if (ir31_26 == 'b000000 &&
               ir5_0   == 'b100010) begin // sub
         rf_wd_s = 1;
         rf_wa_s = 0;
         rf_we = 1;
         rf_r1e = 1;
         rf_r2e = 1;
         add2_s = 1;
         dm_we = 0;
         dm_re = 0; 
			add_sub = 1;
      end
      else begin
         rf_wd_s = 0;
         rf_wa_s = 0;
         rf_we = 0;
         rf_r1e = 0;
         rf_r2e = 0;
         add2_s = 0;
         dm_we = 0;
         dm_re = 0;
			add_sub = 0;
      end
   end
endmodule
