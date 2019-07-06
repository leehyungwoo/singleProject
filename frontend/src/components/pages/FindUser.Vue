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
                    <li class="breadcrumb-item" aria-current="page">Find User</li>
                </ol>
            </nav>
            </div>
        </div>
        <!-- //breadcrumb -->
            
        <!-- contact -->
        <section class="contact py-5">
            <div class="container py-lg-5">
                <h2 class="heading mb-sm-5 mb-4"><strong> Find </strong>User</h2>
                <div class="row">
            
                    <div class="col-md-12 contact-form">
                        <h4 class="mb-4 w3f_title">아이디 비밀번호찾기</h4>
                        <div name="contactform" id="contactform" >
                                <div class="form-group">
                                <label>아이디</label>
                                <input type="text" class="form-control" id="ID" placeholder="Enter ID" name="name" v-model="mid">
                                </div>
                                <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" id="name" placeholder="Enter Email" name="email" v-model="memail">
                                </div>
                                <!-- <div class="form-group">
                                <label>How can we help?</label>
                                <textarea name="issues" class="form-control" id="iq" placeholder="Enter Your Message Here"></textarea>
                                </div>				 -->
                                <button type="submit" @click="submit()" class="btn btn-default">Submit</button>
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
           mid:"",
           memail:"",
            hostname:'http://localhost:9000/userinfo'
        }
    },
    components:{
        headerComponent,
        copyright,
        movetop
    },
    methods:{
        submit(){
                 var data = {
                     mid:this.mid,
                     memail:this.memail
                }
               var headers = {
                    "Content-Type":"application/json",
                    "Authorization":"JWT fefege.."
                }
                axios.post(`${this.hostname}/find`,
                JSON.stringify(data),
                {headers:headers}
                ).then(r=>{
                    alert(r.data.result);
                }).catch(e=>{
                    alert(e)
                })      
        },
 
    }
}
</script>



<style scoped>

</style>
