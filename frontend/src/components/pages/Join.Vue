<template>
  <div>
    <headerComponent/>
    <!-- inner-banner -->
    <section class="inner-banner" id="home">
        <div class="inner-layer">
            <div class="container">
            </div>
        </div>
    </section>
    <!-- //inner-banner -->
    <!-- breadcrumb -->
    <div class="breadcrumb-w3pvt">
        <div class="container">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <!-- <li class="breadcrumb-item"><a href="index.html">Home</a></li> -->
                    <li class="breadcrumb-item" aria-current="page">JoinUs</li>
                </ol>
            </nav>
        </div>
    </div>
    <!-- //breadcrumb -->
    <!-- contact -->
    <section class="contact py-5">
        <div class="container py-lg-5">
            <h2 class="heading mb-sm-5 mb-4"><strong> Join </strong>Us</h2>
            <div class="row">
                <div class="col-lg-12 contact-form mt-md-0 mt-sm-5 mt-4">
                    <h4 class="mb-4 w3f_title">회원가입</h4>
                    <div name="contactform" id="contactform">
                        <div class="form-group">
                            <label>아이디</label>
                            <input type="text" class="form-control" id="userid" placeholder="Enter Id" name="userid" v-model="mid" disabled>
                                <!-- Button trigger modal -->
                            <button type="button" class="btn btn-primary"  data-toggle="modal" data-target="#exampleModal" >
                            중복확인
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                    <button type="button" @click="idConfirmInit" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                   <input type="text" v-model="mid">
                                    <button type="button" class="btn btn-primary" @click="confirm()">중복확인</button>
                                </div>
                                <div class="modal-footer" v-if="idConfirmInit">
                                    <button type="button" class="btn btn-primary"  data-dismiss="modal" >확인</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal" @click="idConfirmInit">취소</button>
                                </div>
                                <div class="modal-footer" v-else>
                                    <button type="button" class="btn btn-primary" >확인</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal" @click="idConfirmInit">취소</button>
                                </div>
                                </div>
                            </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label>
                            <input type="password" class="form-control" id="userpassword" placeholder="Enter Password" name="userpassword" v-model="mpassword">
                        </div>
                        <!-- <div class="form-group">
                            <label>비밀번호 확인</label>
                            <input type="password" class="form-control" id="userpassword_con" placeholder="Enter Password" name="userpassword_con">
                        </div> -->
                        <div class="form-group">
                            <label>이름</label>
                            <input type="text" class="form-control" id="username" placeholder="Enter Name" name="username"
                            v-model="mname">
                        </div>
                        <div class="form-group">
                            <label>이메일</label>
                            <input type="email" class="form-control" id="useremail" placeholder="Enter email" name="useremail"
                            v-model="memail">
                        </div>
                        <div class="form-group">
                            <label>핸드폰번호</label>
                            <input type="tel" class="form-control" id="userphone" placeholder="Enter Phone" name="userphone"
                            v-model="mphone"
                            >
                        </div>
                        <div class="form-group">
                            <label>성별</label><br/>
                            <input type="radio" name="options" id="option1" autocomplete="off"
                                value="m" v-model="mgender" checked> 남성
                            <input type="radio" name="options" id="option2" autocomplete="off"
                                value="w" v-model="mgender"/> 여성   
                        </div>
           
                        <!-- <div class="form-group">
                            <label>선호모임</label>
                            <select class="custom-select">
                                    <option selected>-</option>
                                    <option value="1">테스트</option>
                                </select>
                        </div> -->
                        <!-- <div class="form-group">
                                <label>How can we help?</label>
                                <textarea name="issues" class="form-control" id="iq" placeholder="Enter Your Message Here"></textarea>
                                </div>				 -->
                        <button @click="submit()" class="btn btn-default">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- //contact -->
    <copyright></copyright>
    <movetop></movetop>
    </div>
</template>

<script>
import headerComponent from "@/components/common/headerComponent"
import copyright from "@/components/common/copyright"
import movetop from "@/components/common/movetop"
import axios from "axios"
export default {
    data(){
        return{
            idConfirm:false,
            hostname:'http://localhost:9000/userinfo',
            mid:'',
            mpassword:'',
            mname:'',
            memail:'',
            mphone:'',
            mgender:"m",
        }
    },
    components:{
        headerComponent,
        copyright,
        movetop
    },
    methods:{
        idConfirmInit(){
            this.idConfirm=false;
        },
        confirm(){
            axios.get(`${this.hostname}/join/confirm/${this.mid}`)
            .then(r=>{
                if(r.data.result == true){
                        this.idConfirm = true;
                }else{
                        this.idConfirm = false;
                }
                alert(r.data.msg)
            }).catch(e=>{
                alert('에러')
            })
        },
    
        submit(){
                if(!this.idConfirm){
                    alert('중복확인 하세요')
                    return
                }
                var data = {
                    mid: this.mid,
                    mpassword: this.mpassword,
                    mname: this.mname,
                    memail: this.memail,
                    mphone: this.mphone,
                    mgender: this.mgender,
                }
 
                var headers = {
                    "Content-Type":"application/json",
                    "Authorization":"JWT fefege.."
                }
                axios.post(`${this.hostname}/join`,
                 JSON.stringify(data),
                {headers:headers})
                .then(r=>{
                    alert(r.data.result)
                    this.$router.push({path:'login'})
                    
                }).catch(e=>{
                    alert("통신에러"+e)
                })
        },
        
        
    }
}
</script>



<style scoped>
.btn.btn-secondary.active{background:#ffc168}
 .btn-secondary{background: #fff;}
</style>
