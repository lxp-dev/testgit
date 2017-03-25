/**
 * 
 */

function beforeprint(checkid,obj1,obj2,obj3)
{
	var s1 = document.getElementById(obj1);
	var s2 = document.getElementById(obj2);
	var s3 = document.getElementById(obj3);
	s1.style.display="none";
	s2.style.display="none";
	s3.style.display="none";
	var treeid= document.getElementsByName(checkid);
	for(var i=0;i<treeid.length;i++)
	{
		if(treeid[i].checked)
		{
			treeid[i].style.display="none";
		}else{
			var ych=document.getElementById(treeid[i].value);
			ych.style.display="none";
		}
	}
}
function afterprint(obj1,obj2,obj3)
{
	var s1 = document.getElementById(obj1);
	var s2 = document.getElementById(obj2);
	var s3 = document.getElementById(obj3);
	s1.style.display="block";
	s2.style.display="block";
	s3.style.display="block";
}

function printsf(checkid,delids,span1,span2,span3,url){
	Dialog.confirm("确定打印",function()
			{
				var treeid= document.getElementsByName(checkid);
				var flag = false;
				for(var i=0;i<treeid.length;i++)
				{
					if(treeid[i].checked == true)
					{
						flag = true;
						break;
					}
				}				
				if(flag)
				{
					beforeprint(checkid,span1,span2,span3);
					window.print();
					afterprint(span1,span2,span3);
					getdelids(checkid,delids,url);
				}
				else
				{
					Dialog.alert("请先选择打印项！");
				}				
				return flag;
			}
		);
}