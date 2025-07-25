# Nether_Damage

Плагин для Minecraft (Spigot/Paper), который наносит урон игрокам, находящимся в Нижнем мире (Nether) над бедроком (выше определённой высоты).

## Возможности
- Наносит урон игрокам, если они находятся в Nether выше заданной высоты (по умолчанию Y > 127).
- Настраиваемая сила урона и высота через `config.yml`.
- Команда `/netherdamage_reload` для перезагрузки конфига без перезапуска сервера.
- Пермишен `netherdamage.bypass` — игроки с этим правом не получают урон.
- Пермишен `netherdamage.reload` — доступ к перезагрузке конфига.

## Установка
1. Скомпилируйте плагин и поместите jar-файл в папку `plugins` вашего сервера.
2. Перезапустите сервер или используйте команду `/reload`.
3. Настройте параметры в `plugins/Nether_Damage/config.yml` при необходимости.

## Конфиг (`config.yml`)
```yaml
maxY: 127      # Максимальная высота Y, выше которой наносится урон
damage: 2.0    # Сила урона (2.0 = 1 сердце)
```

## Команды
- `/netherdamage_reload` — перезагрузка конфига (требуется пермишен `netherdamage.reload`).

## Права (Permissions)
- `netherdamage.reload` — позволяет перезагружать конфиг (по умолчанию только OP).
- `netherdamage.bypass` — игрок не получает урон над бедроком в Nether.

## Автор
General_Viski

