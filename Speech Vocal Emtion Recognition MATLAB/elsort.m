function [r,s]=elsort(x,out,k)
try
    g=out.g;
    j=out.j;
    [r,s]=elsort5(x,out,k);
catch
    [r,s]=elsort3(x,out,k);
end