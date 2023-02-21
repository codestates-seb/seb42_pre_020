
import React,{useState, useEffect} from 'react'

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
    <div>
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