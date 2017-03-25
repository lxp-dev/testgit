//设置语言，是否自动检测，默认为TRUE，此处设置为不自动检测，会覆盖默认的设置
FCKConfig.AutoDetectLanguage = true ;

//修改字体，加上中文的字体
FCKConfig.FontNames     = '\u5b8b\u4f53;\u9ed1\u4f53;\u4eff\u5b8b_GB2312;\u65b0\u5b8b\u4f53;\u6977\u4f53_GB2312;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana' ;

//修改"回车"和"Shift+回车"的换行行为（ 默认的回车是一个段落）
FCKConfig.EnterMode = 'br' ;            // p | div | br 

FCKConfig.ShiftEnterMode = 'p' ;    // p | div | br 

//修改编辑区样式文件 ,在fck_editorarea.css中使用@import url（路径）

FCKConfig.EditorAreaCSS = FCKConfig.BasePath + 'css/fck_editorarea.css' ;
