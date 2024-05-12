package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast




class RegisterActivity : AppCompatActivity() {
    lateinit var editTextId: EditText           //id값 입력
    lateinit var btnCheckId: Button            //id값 중복 체크
    lateinit var editTextPassword: EditText    //password 입력
    lateinit var editTextRePassword: EditText  //password 확인
    lateinit var btnRegister: ImageButton      //회원가입 완료버튼
    var CheckId:Boolean=false
    var checkUsername: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joinactivity)

        // 아이디 구현
        btnCheckId.setOnClickListener {
            val user = editTextId.text.toString()

            if (user == "") {
                Toast.makeText(
                    this@,
                    "이메일을 입력해주세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
//                    val checkUsername = DB!!.checkUser(user) //DB 관련 코드
                    if (checkUsername == false) {
                        CheckId = true
                        Toast.makeText(this@RegisterActivity, "사용 가능한 아이디입니다.", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(this@RegisterActivity, "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(this@RegisterActivity, "올바른 이메일 형식이 아닙니다.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }


        // 완료 버튼 클릭 시
        btnRegister.setOnClickListener {
            val user = editTextId.text.toString()
            val pass = editTextPassword.text.toString()
            val repass = editTextRePassword.text.toString()
            val pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z[0-9]]{8,15}$"

            // 사용자 입력이 비었을 때
            if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                Toast.makeText(
                    this@RegisterActivity,
                    "회원정보를 입력해주세요.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // 아이디 중복 확인이 됐을 때
                if (CheckId) {
                    // 비밀번호 형식이 맞을 때
                    if (pass == repass) {
                        // 비밀번호 재확인 성공
                        // val insert = DB?.insertData(user, pass)  //db관련 부분
                        // 가입 성공 시 Toast를 띄우고 메인 화면으로 전환
                        //if (insert == true) {
                        Toast.makeText(
                            this@RegisterActivity,
                            "가입되었습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)

                } else {
                    // 비밀번호 재확인 실패
                    Toast.makeText(
                        this@RegisterActivity,
                        "비밀번호가 일치하지 않습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                // } else {
                // 아이디 중복확인이 되지 않았을 때
                Toast.makeText(
                    this@RegisterActivity,
                    "아이디 중복확인을 해주세요.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
// }
