[filepath,filefolder,filterindex] = uigetfile([defolder,user,'\*.wav'], '请选择待分析语音心情的音频文件');
str=[filefolder,filepath(1:end-4)];

set(h_edit2,'string',filepath(1:end-4));

set(h_text3,'string','处理中...');

set(h_text4,'string','可能需要一分钟左右，请稍候');

set(h_text5,'string','');

set(h_text6,'string','');

set(h_text7,'string','');

set(h_text8,'string','');

set(h_text9,'string','');


drawnow;

[r,s]=elsort(str,out,paranum);


if r==0;
    set(h_text3,'string','判断结果：平静');
    end
if r==1;
    set(h_text3,'string','判断结果：悲伤');
    end
if r==2;
    set(h_text3,'string','判断结果：愤怒');
    end
if r==3;
    set(h_text3,'string','判断结果：高兴');
    end
if r==4;
    set(h_text3,'string','判断结果：惊讶');
    end

set(h_text4,'string','分数：');
set(h_text5,'string',['平静:',num2str(s(1))]);
set(h_text6,'string',['悲伤:',num2str(s(2))]);
set(h_text7,'string',['愤怒:',num2str(s(3))]);
try
set(h_text8,'string',['高兴:',num2str(s(4))]);
set(h_text9,'string',['惊讶:',num2str(s(5))]);
catch
    ;
end
drawnow;