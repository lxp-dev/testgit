	
	//保存下拉列表状态
	function defaultSelValue(obj,priValue){
		var index_ = 0;
		var len_ = obj.options.length;
		for(i=0;i<len_;i++){
			if(obj.options[i].value == priValue){
				obj.selectedIndex = index_;
				break;
			}
			index_++;
		}
	}
	
	
	//全选
	function selectAll(targetObj){
		
		var targetObj = document.getElementById(targetObj);
		for(i =0;i<targetObj.length;i++){
			targetObj.options[i].selected = true;
		}
	}
	
	//添加到第一个下拉列表
	function addToSelOne(targetObj,objOneName,objTwoName,errorMessage){
		var targetObj = document.getElementById(targetObj);
		var objOne = document.getElementById(objOneName);
		var objTwo = document.getElementById(objTwoName);
		
		for(i =0;i<objOne.length;i++){
			if(objOne.options[i].value == targetObj.value){
				alert(errorMessage);
				return false;
			}
		}
		
		for(i =0;i<objTwo.length;i++){
			if(objTwo.options[i].value == targetObj.value){
				alert(errorMessage);
				return false;
			}
		}
		
		if(targetObj.value.trim() != ""){
			objOne.options.add(new Option(targetObj.value,targetObj.value),objOne.length);
			objOne.value = targetObj.value;
		}
		
	}
	
	//移到另一个下拉列表
	function insertSelectValue(objOneName,objTwoName){
		//原Select列表
		var selOne = document.getElementById(objOneName);

		//目标Select列表
		var selTwo = document.getElementById(objTwoName);
		alert(selOne);
		alert(selTwo);
		var nowPlace = selTwo.selectedIndex;
		
		if(selOne.length != 0){
		
			var selOneValue = selOne.options[selOne.selectedIndex].value;
			
			var selOneName =  selOne.options[selOne.selectedIndex].text;
			
			removeSelectValueWithIndex(selOne,selOne.selectedIndex);
		
			selTwo.options.add(new Option(selOneName,selOneValue),nowPlace);
			
			if(nowPlace == -1){
				selTwo.options[selTwo.length-1].selected = true;
			}else{
				selTwo.options[nowPlace].selected = true;
				selTwo.options[nowPlace+1].selected = false;
			}
			
		}
	}
	
	//向上移动
	function moveUp(targetObj){
		var selTwo = document.getElementById(targetObj);
		var nowPlace = selTwo.selectedIndex;
		var nowValue = selTwo.options[nowPlace].value;
		var nowName =  selTwo.options[nowPlace].text;
		if(nowPlace != 0){
			removeSelectValueWithIndex(selTwo,nowPlace);
			selTwo.options.add(new Option(nowName,nowValue),nowPlace-1);
			if(nowPlace-1 == 0)
				selTwo.options[0].selected = true;
			else
				selTwo.options[nowPlace-1].selected = true;
		}
		
	}
	
	//向下移动
	function moveDown(targetObj){
	
		var selTwo = document.getElementById(targetObj);
		var nowPlace = selTwo.selectedIndex;
		var nowValue = selTwo.options[nowPlace].value;
		var nowName =  selTwo.options[nowPlace].text;
		if(nowPlace != selTwo.length){
			removeSelectValueWithIndex(selTwo,nowPlace);
			selTwo.options.add(new Option(nowName,nowValue),nowPlace+1);
			if(nowPlace == selTwo.length-1)
				selTwo.options[selTwo.length-1].selected = true;
			else
				selTwo.options[nowPlace+1].selected = true;
		}
	}
	
	//清空下拉列表内容
	function removeSelectValue(obj){
		for(i = 0;i<obj.length;i++)
		{
			obj.remove(0);
		}
	}
	
	//删除下拉列表某一项
	function removeSelectValueWithIndex(obj,index){
		obj.remove(index);
	}