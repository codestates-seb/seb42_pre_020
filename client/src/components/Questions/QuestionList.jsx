import {Link} from 'react-router-dom'
import styles from './QuestionList.module.css'


function QuestionList({questions}) {

  
  return (
    <div>
      {
        questions.map((question) => (
          <div key={question.id} className={styles.container}>
            <div className={styles.left}>
              <span>votes</span><span>0</span>
              <span>votes</span><span>0</span>
              <span>votes</span><span>0</span>
            </div>
            <div className={styles.right}>
              <h2 className={styles.right_title}>
                <Link to='/my' href="url">{question.title}</Link>
                </h2>
              <div className={styles.right_tag}>
                <a href="url">{question.tag}</a>
              </div>
            </div>
          </div>
        ))
      }
    </div>
  )
}
export default QuestionList


 




