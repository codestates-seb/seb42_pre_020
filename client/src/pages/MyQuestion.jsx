import React,{useState,useEffect} from 'react'
import AddBody from '../components/Questions/AddBody'
import styles from '../components/Questions/MyQuestion.module.css'
import Button from '../components/UI/Button/Button'
import { AiFillCaretUp, AiFillCaretDown } from "react-icons/ai" ;   
function MyQuestion() {
  // db에서 데이터를 받아와서 뿌릴 건데 테스트 용으로 임시로 작성한 초기값 입니다.
  const [questions, setQuestions] = useState([{id:0, title:'what is react', body:'React makes it painless to create interactive UIs. Design simple views for each state in your application, and React will efficiently update and render just the right components when your data changes.' , tag:'react'}])

const [answer, setAnswer] = useState('')
const [questionlike, setQuestionLike] = useState(0)
const [answerlike, setAnswerLike] = useState(0)
const answerHandler = (e) => {
  setAnswer(e.target.value)
}

const questionlikeHandler = () => {
  setQuestionLike(questionlike + 1)
}

const questionhateHandler = () => {
  setQuestionLike(questionlike - 1)
}

const answerlikeHandler = () => {
  setAnswerLike(answerlike - 1)
}

const answerhateHandler = () => {
  setAnswerLike(answerlike - 1)
}



// db에서 데이터를 가져와서, 가져 온 데이터를 state인 questions에 넣어주는 코드를 짜 보았습니다.
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
  <div className={styles.container}>
    <div className={styles.question}>
      {
        questions.map((question) => (
          <div key={question.id}>
            <div className={styles.header}>
              <h1>{question.title}</h1>
              <Button text='Ask Question' url='/ask'/>
            </div>
            <div className={styles.myquest}>
              <div className={styles.like}>
                <button onClick={questionlikeHandler}><AiFillCaretUp /></button>
                <div>{questionlike}</div>
                <button onClick={questionhateHandler}><AiFillCaretDown /></button>
              </div>
              <div className={styles.body}>
                {question.body}
              </div>
            </div>
            <div className={styles.tag}>
              <a href="url">{question.tag}</a>
            </div>
          </div>

        ))
      }
      <div className={styles.buttons}>
        <div className={styles.edit}>
          <Button text='Edit'/>
        </div>  
        <div className={styles.delete}>
          <Button text='Delete'/>
        </div>
      </div>
    </div>
    

    <h2 className={styles.answer_title}>Answer</h2>
    <div className={styles.show_answer}>
      <div className={styles.like}>
        <button onClick={answerlikeHandler}><AiFillCaretUp /></button>
        <div>{answerlike}</div>
        <button onClick={answerhateHandler}><AiFillCaretDown /></button>
      </div>
      <div className={styles.answer}>
        {answer && answer}
      </div>
    </div>
    
    <div className={styles.your_answer}>
      <h2 className={styles.title}>Your Answer</h2>
      <form className={styles.new_answer}>
        <AddBody body={answer} bodyHandler={answerHandler} placeholder='write your answer'/>
        <Button onClick={answerHandler} text='Post Your Answer'/>
      </form>
    </div>
  </div>  
    
)
}

      
      
      
      


    

    




          


export default MyQuestion