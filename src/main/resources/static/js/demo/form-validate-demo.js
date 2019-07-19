//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
        $.validator.setDefaults({
            highlight: function (element) {
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            },
            success: function (element) {
                element.closest('.form-group').removeClass('has-error').addClass('has-success');
            },
            errorElement: "span",
            errorPlacement: function (error, element) {
                if (element.is(":radio") || element.is(":checkbox")) {
                    error.appendTo(element.parent().parent().parent());
                } else {
                    error.appendTo(element.parent());
                }
            },
            errorClass: "help-block m-b-none",
            validClass: "help-block m-b-none"

        });


        jQuery.validator.addMethod("isExist", function(value, element){
                var urlArr = $('#urlArr').val();
                return urlArr.indexOf(value+',') == -1;
            },"此页面编码已存在，请更换");

        //以下为官方示例
        $().ready(function () {
            // validate signup form on keyup and submit
            var icon = "<i class='fa fa-times-circle'></i> ";
            $("#signupForm").validate({
                rules: {
                    // firstname: "required",
                    // lastname: "required",
                    loginAccount: {
                        required: true,
                        minlength: 2
                    },
                    loginPass: {
                        required: true,
                        minlength: 5
                    },
                    confirm_password: {
                        required: true,
                        minlength: 5,
                        equalTo: "#loginPass"
                    },
                    roleIds: {
                        required: true,
                        minlength: 1,
                    }
                    // email: {
                    //     required: true,
                    //     email: true
                    // },
                    // topic: {
                    //     required: "#newsletter:checked",
                    //     minlength: 2
                    // },
                    // agree: "required"
                },
                messages: {
                    // firstname: icon + "请输入你的姓",
                    // lastname: icon + "请输入您的名字",
                    loginAccount: {
                        required: icon + "请输入您的用户名",
                        minlength: icon + "用户名必须两个字符以上"
                    },
                    loginPass: {
                        required: icon + "请输入您的密码",
                        minlength: icon + "密码必须5个字符以上"
                    },
                    confirm_password: {
                        required: icon + "请再次输入密码",
                        minlength: icon + "密码必须5个字符以上",
                        equalTo: icon + "两次输入的密码不一致"
                    },
                    roleIds: {
                        required: icon + "请勾选用户对应的角色",
                        minlength: icon + "至少勾选一个角色"
                    }
                    // email: icon + "请输入您的E-mail",
                    // agree: {
                    //     required: icon + "必须同意协议后才能注册",
                    //     element: '#agree-error'
                    // }
                }


                // propose username by combining first- and lastname
                // $("#loginAccount").focus(function () {
                //     var firstname = $("#firstname").val();
                //     var lastname = $("#lastname").val();
                //     if (firstname && lastname && !this.value) {
                //         this.value = firstname + "." + lastname;
                //     }
                // });
            });

            $("#roleForm").validate({
                rules: {
                    // firstname: "required",
                    // lastname: "required",
                    roleKey: {
                        required: true,
                        minlength: 2
                    },
                    roleValue: {
                        required: true,
                        minlength: 2
                    }
                },
                messages: {
                    roleKey: {
                        required: icon + "请输入角色编码",
                        minlength: icon + "角色编码必须两个字符以上"
                    },
                    roleValue: {
                        required: icon + "请输入角色名称",
                        minlength: icon + "密码必须2个字符以上"
                    }
                }
            });

            $("#authForm").validate({
                rules: {
                    menuCode: {
                        required: true,
                        minlength: 1,
                        isExist: true

                    },
                    menuName: {
                        required: true,
                        minlength: 2
                    },
                    menuType: {
                        required: true,
                    },
                    dataUrl: {
                        required: true,
                        minlength: 2
                    },
                },
                messages: {
                    menuCode: {
                        required: icon + "请输入页面编码",
                        minlength: icon + "角色编码必须1个字符以上"
                    },
                    menuName: {
                        required: icon + "请输入页面名称",
                        minlength: icon + "页面名称必须2个字符以上"
                    },
                    menuType: {
                        required: icon + "请选择页面级别",
                    },
                    dataUrl: {
                        required: icon + "请输入页面路径",
                        minlength: icon + "URL必须2个字符以上"
                    }
                }
            });
        });