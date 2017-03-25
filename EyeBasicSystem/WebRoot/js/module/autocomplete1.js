$().ready(function() {

	var url = "selPersonInfoAll.action";

	var options = {
		width : 260,
		selectFirst : false,
		autoFill : false,
		dataType : 'json',
		selectFirst : true,
		parse : function(data) {
			var json = data.personAjax;

			for (i = 0; i < json.length; i++) {
				json[i] = {
					data : [ json[i] ],
					resulet : json[i],
					value : json[i]
				};
			}
			return json;
		}
	};

	
		// 接诊医师
		$("#soprexaminedoctorName").autocomplete(url, options);

		$("#soprexaminedoctorName").result(
				function(event, data, formatted) {
					if (data) {
						$(this).val(formatted);
						$("#soprexaminedoctorID").val(
								formatted.replace(/(^.* )|[\\(\\)]/g, ""));
					}
				});
		

	});