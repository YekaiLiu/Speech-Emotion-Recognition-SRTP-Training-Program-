function [str,ele]=scanfolder(path,mch,no)

for k=1:length(mch)
    s=dir([path,'*',mch(k),'*.wav']);
    clear strp;
    clear elep;
%     length(s)
    for i=1:length(s)
        fname=s(i).name;
        strp(i,:)=fname(1:end-4);
        elep(i)=no(k);
    end
    try 
        str=[str;strp];
        ele=[ele,elep];
    catch
        str=strp;
        ele=elep;
    end
end
