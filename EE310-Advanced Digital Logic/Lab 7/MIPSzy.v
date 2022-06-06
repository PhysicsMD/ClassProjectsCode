`timescale 1ns / 1ps
module MIPSzy(clk, rst, dbg_a, dbg_e, dbg_o);
   input clk, rst;
  
   input [9:0] dbg_a;
   input dbg_e;
   output [31:0] dbg_o;
  
   // Ctrl wires
   wire rf_wd_s, rf_wa_s, rf_we, rf_r1e, rf_r2e;
   wire add2_s;
   wire dm_we, dm_re;
   
   // PC wires
   wire [31:0] pc_out, pc_inc4;
   
   // IM/IR wires
   wire [31:0] ir;
   wire [5:0] ir31_26, ir5_0;
   wire [4:0] ir20_16, ir15_11, ir25_21;
   wire [15:0] ir15_0;
   
   // SW wires
   wire [31:0] ir15_0_se;
   
   // RF wires
   wire [4:0] rf_wa;
   wire [31:0] rf_wd;
   wire [31:0] rf_r1d, rf_r2d;
   
   // Adder wires
   wire [31:0] add2, add1, add_sum;
	wire add_sub;
   
   // DM wires
   wire [31:0] dm_a;
   wire [31:0] dm_wd;
   wire [31:0] dm_rd;

   // internal connections
   assign dm_a = rf_r1d + ir15_0_se;
   assign dm_wd = rf_r2d;
   assign add1 = rf_r1d; 
  
   assign ir31_26 = ir[31:26];
   assign ir5_0 = ir[5:0];
   assign ir20_16 = ir[20:16];
   assign ir15_11 = ir[15:11];
   assign ir25_21 = ir[25:21];
   assign ir15_0 = ir[15:0];
  
   // Component instantiations
   mipszy_ctrl    CTRL(ir31_26, ir5_0,
                       rf_wd_s, rf_wa_s, rf_we, rf_r1e, rf_r2e,
                       add2_s, dm_we, dm_re, add_sub);
   register_32    PC(clk, rst, 1'b1, pc_inc4, pc_out);
   inc4_32        PC_inc(pc_out, pc_inc4);
   mux2x1_32      RF_wd_mux(add_sum, dm_rd, rf_wd_s, rf_wd);
   mux2x1_5       RF_wa_mux(ir20_16, ir15_11, rf_wa_s, rf_wa);
   regfile_32x32  RF(clk, rst, 
                     ir25_21, rf_r1d, rf_r1e,
                     ir20_16, rf_r2d, rf_r2e,
                     rf_wa, rf_wd, rf_we);
   signext_16_32  SE(ir15_0, ir15_0_se);
   mux2x1_32      ADD_mux(rf_r2d, ir15_0_se, add2_s, add2);
   adder_32       ADD(add1, add2, add_sum, add_sub);
   mem_1024x32    IM(clk, pc_out[11:2], ir, 1'b1, 10'd0, 32'd0, 1'b0, 10'd0, 1'b0, );
   mem_1024x32    DM(clk, dm_a[11:2], dm_rd, dm_re, 
                     dm_a[11:2], dm_wd, dm_we,
                     dbg_a, dbg_e, dbg_o);
endmodule
