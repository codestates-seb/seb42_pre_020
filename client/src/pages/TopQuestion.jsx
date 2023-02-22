import React,{useState, useEffect} from 'react'
import style from '../components/Questions/TopQuestion.module.css'
import QuestionList from '../components/Questions/QuestionList'
import Button from '.././components/UI/Button/Button'


function TopQuestion() {
  // db에서 데이터를 받아와서 뿌려줘야 하는데 테스트 용으로 임시로 작성된 useState 초기값 입니다.
  const [questions, setQuestions] = useState([{id:0, title:'what is react', tag:'react'}, {id:1, title:'what is js',tag:'js'}])
  
  useEffect(() => {
    fetch('')
      .then(res => {
        return res.json()
      })
      .then(data => {
        setQuestions(data)
      })
  },[])
  
  return (
  <>
    <div className={style.header}>
      <h1 className={style.header_title}>Top Questions</h1>
      <div>
      <Button text='Ask Question' url='/ask'/>
      </div>
    </div>
    <QuestionList questions={questions}/>
  </>

  )
}



export default TopQuestion