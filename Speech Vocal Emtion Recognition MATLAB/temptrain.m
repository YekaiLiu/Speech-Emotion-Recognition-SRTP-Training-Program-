function temptrain(str,tempname,path,ele,sel)
si=size(str);
if sel==1
    try
        disp('use old template');
        s=load([path,tempname]);
        temp=s.temp;
    catch
        disp('create new template');
    end
elseif sel==0
    disp('create new template');
end
for k=1:length(str)
    xy=[ele(k);paracal([path,str(k,:)])];
    try
        temp=[temp,xy];
    catch
        temp=xy;
    end
end
save([path,tempname],'temp');