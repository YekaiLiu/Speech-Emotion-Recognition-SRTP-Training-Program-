[filepath,filefolder,filterindex] = uigetfile([defolder,user,'\*.wav'], '��ѡ������������������Ƶ�ļ�');
str=[filefolder,filepath(1:end-4)];

set(h_edit2,'string',filepath(1:end-4));

set(h_text3,'string','������...');

set(h_text4,'string','������Ҫһ�������ң����Ժ�');

set(h_text5,'string','');

set(h_text6,'string','');

set(h_text7,'string','');

set(h_text8,'string','');

set(h_text9,'string','');


drawnow;

[r,s]=elsort(str,out,paranum);


if r==0;
    set(h_text3,'string','�жϽ����ƽ��');
    end
if r==1;
    set(h_text3,'string','�жϽ��������');
    end
if r==2;
    set(h_text3,'string','�жϽ������ŭ');
    end
if r==3;
    set(h_text3,'string','�жϽ��������');
    end
if r==4;
    set(h_text3,'string','�жϽ��������');
    end

set(h_text4,'string','������');
set(h_text5,'string',['ƽ��:',num2str(s(1))]);
set(h_text6,'string',['����:',num2str(s(2))]);
set(h_text7,'string',['��ŭ:',num2str(s(3))]);
try
set(h_text8,'string',['����:',num2str(s(4))]);
set(h_text9,'string',['����:',num2str(s(5))]);
catch
    ;
end
drawnow;