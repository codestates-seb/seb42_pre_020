import React,{useState, useEffect} from 'react'
import style from './TopQuestion.module.css'
import QuestionList from '../components/Questions/QuestionList'


function TopQuestion() {
  const [questions, setQuestions] = useState(null)

  useEffect(() => {
    fetch('url')
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
      <button className={style.header_button}>Ask Question</button>
    </div>
    questions <QuestionList questions={questions}/>
  </>

  )
}

export default TopQuestion