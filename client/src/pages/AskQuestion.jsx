import React, {useState} from 'react'
import AddTitle from '../components/Questions/AddTitle'
import AddBody from '../components/Questions/AddBody'
import AddTag from '../components/Questions/AddTag'
import AddButton from '../components/Questions/AddButton'
import styles from '../components/Questions/AskQuestion.module.css'



// 화면에 표시될 긴 텍스트인데 임시로 이곳에 작성하였습니다.(이것도 db에 저장해서 불러오는 건가요..?)
const BLUEBOX_CONTENT = `You're ready to ask a programming-related question and this form will help guide you through
the process Looking to ask a non-programming question? See the topics here to find a relevant site.`
const BLUEBOX_LIST = [
  'Summarize your problem in a one-line title.',
  'Describe your problem in more detail.',
  'Describe what you tried and what you expected to happen.'
]



let nextId = 0

function AskQuestion() {
  const [inputs, setInputs] = useState([])
  const [title, setTitle] = useState('')
  const [tag, setTag] = useState('')
  const [body, setBody] = useState('') 

  const titleHandler = (e) => {
    setTitle(e.target.value)
  }

  const bodyHandler = (e) => {
    setBody(e.target.value)
  }

  const tagHandler = (e) => {
    setTag(e.target.value)
  }
  
// AskQuestion 페이지에서 Ask Question 버튼 클릭시 입력받은 3개의 상태값을 배열 안에 객체로 담아 db에 보내는 코드를 짜 보았습니다.(맞는지는 잘 모르겠습니다..)
// 버튼 클릭시 유효성 검사를 하는 것은 곧 구현해 보겠습니다. 반응형 css도 다시 구현해 보겠습니다. tag의 경우 여러개를 입력 받을 수 있기 때문에 배열로 만들어야 할 것 같은데 이것도 다시 구현해 보겠습니다.
  
const clickHandler = (e) => {
    e.preventDefault()
    setTitle('')
    setBody('')
    setTag('')
    setInputs([{id: nextId++, title: title, body: body, tag: tag}, ...inputs ])
        fetch('', {
      method: 'POST',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify({ inputs })
    })
      .then((response) => response.json())
      .then((json) => console.log(json))
      .catch((error) => console.log(error));

  }  

  return (
    <div className={styles.container}>
      <section className={styles.section}>
        <h1 className={styles.section_title}>
          Ask a public question
        </h1>
        <div className={styles.section_bluebox}>
          <h2 className={styles.bluebox_title}>
            Writing a good question
          </h2>
          <h3 className={styles.bluebox_content}>
            {BLUEBOX_CONTENT}
          </h3>
          <h4>
          Steps
          </h4>
          <ul className={styles.bluebox_list}>
              {
                BLUEBOX_LIST.map((list, idx) => {
                  return <li key={idx}>{list}</li>
                })
              }
          </ul>
      </div>
      </section>

      <form className={styles.form}>
        <AddTitle titleHandler={titleHandler} title={title}/>
        <AddBody body={body} bodyHandler={bodyHandler} title='What are the details of your problem?'/>
        <AddTag tagHandler={tagHandler} tag={tag} />
        <AddButton text='Ask Question' onClick={clickHandler} />
      </form>
    </div>
  )
}


export default AskQuestion













  