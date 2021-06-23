function tempadd(user,mch,no)
path=['D:\xlj\',user,'\'];
tempname=['temp',user];
[str,ele]=scanfolder(path,mch,no);
temptrain(str,tempname,path,ele,1);