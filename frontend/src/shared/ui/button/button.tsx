import { ButtonProps } from './button-types';
import styles from './button.module.scss';

export const Button = ({ style, children }: ButtonProps) => {
	return (
		<>
			{style === 'primary' && (
				<button className={styles.btn_primary}>{children}</button>
			)}
			{style === 'secondary' && (
				<button className={styles.btn_secondary}>{children}</button>
			)}
			{style === 'tertiary' && (
				<button className={styles.btn_tertiary}>{children}</button>
			)}
		</>
	);
};
