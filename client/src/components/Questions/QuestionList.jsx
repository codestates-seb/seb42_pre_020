// import React from 'react'
import React,{useState, useEffect} from 'react'
import styles from './QuestionList.module.css'
function QuestionList() {
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
    <div className={styles.QuestionList}>
      {
        questions.map((quest) => (
          <div key={quest.id}>
            <h2>{quest.title}</h2>
            <button><a href="%">{quest.tag}</a></button>
          </div>
          
          
        ))
      }
    </div>
  )
}

export default QuestionList