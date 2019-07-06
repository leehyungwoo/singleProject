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
                    <li class="breadcrumb-item" aria-current="page">Login</li>
                </ol>
            </nav>
        </div>
    </div>
    <!-- //breadcrumb -->
    <!-- contact -->
    <section class="contact py-5">
        <div class="container py-lg-5">
            <h2 class="heading mb-sm-5 mb-4"><strong> Login </strong></h2>
            <div class="row">
                <div class="col-lg-12 contact-form mt-md-0 mt-sm-5 mt-4">
                    <h4 class="mb-4 w3f_title">로그인</h4>
                    <div name="contactform" id="contactform">
                        <div class="form-group">
                            <label>아이디</label>
                            <input type="text" class="form-control" id="mid" placeholder="Enter Id" name="mid" v-model="mid">
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label>
                            <input type="password" class="form-control" id="mpassword" placeholder="Enter Password" 
                            v-model="mpassword"
                            name="mpassword">
                        </div>
                        <button @click="login()" class="btn btn-default">Login</button>
                        <router-link to="find-user" class="btn btn-default">FindUser</router-link>
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
            hostname:'http://localhost:9000/userinfo',
            mid:'',
            mpassword:'',
        }
    },
    components:{
        headerComponent,
        copyright,
        movetop
    },
    methods:{
        login(){
                 var data = {
                     mid:this.mid,
                     mpassword:this.mpassword
                }
                 var headers = {
                    "Content-Type":"application/json",
                    "Authorization":"JWT fefege.."
                }

                axios.post(`${this.hostname}/login`,
                 JSON.stringify(data),
                {headers:headers})
                .then(r=>{
                   alert("login : "+r.data.result)
                   if(r.data.result === "sucess"){
                   localStorage.setItem('user',r.data.user)
                   this.$store.state.userInfo.logintf=true;
                   this.$store.state.userInfo.userId=r.data.user;
                   this.$router.push({path:'/'})
                   }else{
                       this.$store.state.userInfo.logintf=false;
                   this.$store.state.userInfo.userId="";

                   }
                }).catch(e=>{
                    alert("통신에러"+e)
                })
        },
        
    }
}
</script>



<style scoped>
#contactform a{border: 2px solid #ffc168;
    border-radius: 5px;
    color: #fff;
    background: #ffc168;
    font-size: 16px;
    letter-spacing: 1px;
    padding: 8px 30px;
    display: inline-block;}
</style>
