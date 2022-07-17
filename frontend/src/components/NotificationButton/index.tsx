import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg';
import { BASE_URL } from '../../utils/Request';
import './styles.css';

type Props = {
    saleId: string
}

function handleClick(id: string) {
    axios.get(`${BASE_URL}/sales/${id}/notification`)
    .then(response => {
        toast.success("Sms enviado com sucesso")
    }, error => {
        toast.error("Falha ao enviar sms")
    })
}

function NotificationButton({ saleId }: Props) {

    return (
        <div className="dsmeta-red-btn" onClick={() => {
            handleClick(saleId)
        }
        }>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton
