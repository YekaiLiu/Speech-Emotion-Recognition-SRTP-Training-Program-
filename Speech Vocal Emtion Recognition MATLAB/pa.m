function xpt=pa(xp)
fl=0;
if xp(1)<xp(2)
    xpt(1)=xp(1);
    fl=1;
end
for i=1:length(xp)-2
    if min(xp(i:i+2))==xp(i+1) & i>fl
        try
            xpt=[xpt,xp(i+1)];
        catch
            xpt(1)=xp(i+1);
        end
    end
end